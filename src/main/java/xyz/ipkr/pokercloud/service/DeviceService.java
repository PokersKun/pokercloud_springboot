package xyz.ipkr.pokercloud.service;

import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xyz.ipkr.pokercloud.entity.ControlEntity;
import xyz.ipkr.pokercloud.entity.DeviceEntity;
import xyz.ipkr.pokercloud.mapper.DeviceMapper;
import xyz.ipkr.pokercloud.mqtt.IMqttSender;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

@Service
public class DeviceService {

    private static Gson gson = new Gson();

    @Autowired(required = false)
    private DeviceMapper deviceMapper;

    @Resource
    private IMqttSender mqttSender;

    public boolean addDevice(Long device_id, String name, String type, String location, String manager) {
        return deviceMapper.insert(device_id, name, type, location, manager) > 0;
    }

    public DeviceEntity getDeviceByDeviceId(Long device_id) {
        return deviceMapper.queryDeviceByDeviceId(device_id);
    }

    public boolean checkDevice(Long device_id) {
        return deviceMapper.queryDeviceIdByDeviceId(device_id) > 0;
    }

    public void updateDeviceStatus(Long device_id, Byte status, Integer action) {
        deviceMapper.updateStatusByDeviceId(device_id, status, action);
    }

    public String controlDevice(Long device_id, String type, Integer code) {
        ControlEntity controlEntity = new ControlEntity();
        controlEntity.setId(device_id);
        controlEntity.setCode(code);
        mqttSender.sendToMqtt("test/" + type + "/ctrl",gson.toJson(controlEntity));
        return "success";
    }

    public String creatQRCode(String content, int width, int height) throws IOException {

        String resultImage = "";
        if (!StringUtils.isEmpty(content)) {
            ServletOutputStream stream = null;
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            @SuppressWarnings("rawtypes")
            HashMap<EncodeHintType, Comparable> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 指定字符编码为“utf-8”
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M); // 指定二维码的纠错等级为中级
            hints.put(EncodeHintType.MARGIN, 2); // 设置图片的边距

            try {
                QRCodeWriter writer = new QRCodeWriter();
                BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height, hints);

                BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
                ImageIO.write(bufferedImage, "png", os);
                /**
                 * 原生转码前面没有 data:image/png;base64 这些字段，返回给前端是无法被解析，可以让前端加，也可以在下面加上
                 */
                resultImage = "data:image/png;base64," + Base64.getEncoder().encodeToString(os.toByteArray());

                return resultImage;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            }
        }
        return null;
    }

    public boolean updateInfo(Long device_id, String name, String type, String location) {
        return deviceMapper.updateInfoByDeviceId(device_id, name, type, location) > 0;
    }

    public boolean deleteUserDeviceByDeviceId(Long device_id) {
        return deviceMapper.deleteByDeviceId(device_id) > 0;
    }

}
