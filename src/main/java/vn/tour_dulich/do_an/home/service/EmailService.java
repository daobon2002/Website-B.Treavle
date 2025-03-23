package vn.tour_dulich.do_an.home.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String name, String tourName, String bookingDate, String sodienthoai, int soluong, String sotien) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");


        // Tạo nội dung HTML cho email
        String emailContent = generateEmailContent(to, name, tourName, bookingDate, sodienthoai, soluong,sotien);

        helper.setFrom("bo5806501@gmail.com");
        helper.setTo(to);
        helper.setSubject("Xác nhận đặt tour");
        helper.setText(emailContent, true); // true để chỉ định rằng nội dung là HTML

        mailSender.send(message);
        System.out.println("Email đã được gửi thành công!");
    }

    private String generateEmailContent(String to, String name, String tourName, String bookingDate, String sodienthoai, int soluong, String sotien) {
        // Create HTML content for the email
        StringBuilder content = new StringBuilder();
        content.append("<html><head>")
                .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n")
                .append("<style>")
                .append("body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f9f9f9; display: flex; justify-content: center; align-items: center; min-height: 100vh; }")
                .append(".container { max-width: 800px; background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); text-align: left; }")  // Căn trái cho nội dung trong container
                .append("h1 { color: #d9534f; text-align: center; }") // Căn giữa tiêu đề
                .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
                .append("th, td { border: 1px solid #ccc; padding: 10px; text-align: left; font-family: Arial, sans-serif; }")
                .append("th { background-color: #f2f2f2; }")
                .append(".highlight { color: red; font-style: italic; }")
                .append(".btn { display: inline-block; padding: 10px 20px; color: #fff; background-color: #d9534f; border: none; border-radius: 5px; cursor: pointer; margin-top: 20px; font-family: Arial, sans-serif; }")
                .append(".btn:hover { background-color: #c9302c; }")
                .append("</style>")
                .append("</head><body>")
                .append("<div class='container'>")
                .append("<h1>XÁC NHẬN ĐƠN HÀNG!</h1>")
                .append("<p>Khách Hàng: ").append(name).append("</p>")
                .append("<p>Ngày Đặt: ").append(bookingDate).append("</p>")
                .append("<p>Ngân Hàng: Ngân Hàng TMCP Quân Đội/MB BANK</p>")
                .append("<p>Số Tài Khoản: 1549122052002</p>")
                .append("<p>Nội Dung Chuyển Khoản: <span>MB BANK</span> <span>_" + name + "_</span> <span>" + sodienthoai + "</span></p>")
                .append("<table><thead><tr><th>Tên Tour</th><th>Số Lượng</th><th>Thành Tiền</th></tr></thead>")
                .append("<tbody><tr>")
                .append("<td>").append(tourName).append("</td>")
                .append("<td>").append(soluong).append("</td>")
                .append("<td>").append(sotien).append(" VND</td>")
                .append("</tr><tr><td colspan='2'><strong>Tổng Tiền:</strong></td>")
                .append("<td><strong>").append(sotien).append(" VND</strong></td>")
                .append("</tr></tbody></table>")
                .append("<p>Cảm ơn bạn đã đặt hàng! Chúng tôi sẽ xử lý đơn hàng của bạn sớm nhất có thể.</p>")
                .append("<p class='highlight'>Lưu ý: Vui lòng ghi chính xác nội dung chuyển khoản. Sai thông tin, chúng tôi không chịu trách nhiệm.</p>")
                .append("<p>Sau khi hoàn tất việc thanh toán, quý khách vui lòng gửi lại gmail cho chúng tôi với nội dung: \"<strong class='highlight'>tôi đã thanh toán thành công</strong>\".</p>")
                .append("</div>")
                .append("</body></html>");
        return content.toString();
    }


    public void sendEmail1(String gmail, String hoten, String tourName, String bookingDate, String sodienthoai, int soluong, String sotien, String diadiem, String lichtrinh, String ngaykhoihanh, String tourNgaykhoihanh, String s, String mota, Integer soday, Integer soluongghe, String string) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        // Cập nhật nội dung email để bao gồm thông tin đầy đủ
        String emailContent = generateEmailContent1(gmail, hoten, tourName, bookingDate, sodienthoai, soluong, sotien, diadiem, lichtrinh,ngaykhoihanh,s,soday,soluongghe,string);

        helper.setFrom("bo5806501@gmail.com");
        helper.setTo(gmail);
        helper.setSubject("Xác nhận đặt tour");
        helper.setText(emailContent, true);

        mailSender.send(message);
        System.out.println("Email đã gửi tới: " + gmail);
    }

    private String generateEmailContent1(String to, String name, String tourName, String bookingDate, String sodienthoai, int soluong, String sotien, String diadiem, String lichtrinh, String ngaykhoihanh, String s, Integer soday, Integer soluongghe, String string) {
        return "<html><head>"
                + "<meta charset=\"UTF-8\">"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "<title>Xác Nhận Đặt Tour</title>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; margin: 20px; padding: 0; color: #333; }"
                + "h1 { text-align: center; }"
                + ".order-confirmation { border: 1px solid #ccc; padding: 20px; border-radius: 5px; max-width: 600px; margin: auto; }"
                + ".order-header, .order-footer { text-align: center; }"
                + "table { width: 100%; border-collapse: collapse; margin-top: 20px; }"
                + "th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }"
                + "th { background-color: #f2f2f2; }"
                +"p { color: black; }"
                + ".total { font-weight: bold; font-size: 1.2em; text-align: right; }"
                + "</style>"
                + "</head><body>"
                + "<div class=\"order-confirmation\">"
                + "<h1 style=\"color: orange;\">HÓA ĐƠN ĐẶT TOUR</h1>"
                + "<div class=\"order-header\">"
                + "<p>Tên Công Ty: Công ty Cổng Phần B.Travel</p>"
                + "<p>Địa Chỉ: 123 Đường ABC, Thành Phố XYZ</p>"
                + "<p>Số Điện Thoại: 0123456789</p>"
                +"<p>Gmail Công ty:B.Travel@gmail.com </p>"
                + "</div>"
                + "<div class=\"customer-info\">"
                + "<p><strong>Khách Hàng:</strong> " + name + "</p>"
                + "<p><strong>Số Điện Thoại:</strong> " + sodienthoai + "</p>"
                + "<p><strong>Ngày Đặt Tour:</strong> " + bookingDate + "</p>"
                + "<p><strong>Địa Điểm Xuất Phát:</strong> " + diadiem + "</p>"
                + "</div>"
                + "<table>"
                + "    <thead>"
                + "        <tr>"
                + "            <th>Tên Tour</th>"
                + "            <th>Giá</th>"
                + "            <th>Số Lượng</th>"
                + "            <th>Tổng Cộng</th>"
                + "        </tr>"
                + "    </thead>"
                + "    <tbody>"
                + "        <tr>"
                + "            <td>" + tourName + "</td>"
                + "            <td>" + s + " VND</td>"
                + "            <td>" + soluong + "</td>"
                + "            <td>" + sotien + " VND</td>"
                + "        </tr>"
                + "    </tbody>"
                + "</table>"
                + "<div class=\"customer-info\">"
                + "<p>Cảm ơn bạn đã đặt tour! Chúc các bạn có 1 chuyển đi vui vẻ bên gia đình và người thương.</p>"
                + "</div>"
                + "</div>"
                + "</body></html>";

    }
    public void sendEmails1(String gmail, String hoten, String tourName, String bookingDate, String sodienthoai, int soluong, String sotien, String diadiem, String lichtrinh, String ngaykhoihanh, String tourNgaykhoihanh, String s, String mota, Integer soday, Integer soluongghe, String string) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        // Cập nhật nội dung email để bao gồm thông tin đầy đủ
        String emailContent = generateEmailContent2(gmail, hoten, tourName, bookingDate, sodienthoai, soluong, sotien, diadiem, lichtrinh,ngaykhoihanh,s,soday,soluongghe,string);

        helper.setFrom("bo5806501@gmail.com");
        helper.setTo(gmail);
        helper.setSubject("Xác nhận đặt tour");
        helper.setText(emailContent, true);

        mailSender.send(message);
        System.out.println("Email đã gửi tới: " + gmail);
    }

    private String generateEmailContent2(String to, String name, String tourName, String bookingDate, String sodienthoai, int soluong, String sotien, String diadiem, String lichtrinh, String ngaykhoihanh, String s, Integer soday, Integer soluongghe, String string) {
        return "<html><head>"
                + "<meta charset=\"UTF-8\">"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "<title>Xác Nhận Đặt Tour</title>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; margin: 20px; padding: 0; color: #333; }"
                + "h1 { text-align: center; }"
                + ".order-confirmation { border: 1px solid #ccc; padding: 20px; border-radius: 5px; max-width: 600px; margin: auto; }"
                + ".order-header, .order-footer { text-align: center; }"
                + "table { width: 100%; border-collapse: collapse; margin-top: 20px; }"
                + "th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }"
                + "th { background-color: #f2f2f2; }"
                +"p { color: black; }"
                + ".total { font-weight: bold; font-size: 1.2em; text-align: right; }"
                + "</style>"
                + "</head><body>"
                + "<div class=\"order-confirmation\">"
                + "<h1 style=\"color: orange;\">THƯ XIN LỖI</h1>"
                + "<div class=\"order-header\">"
                + "<p>Tên Công Ty: Công ty Cổng Phần B.Travel</p>"
                + "<p>Địa Chỉ: 123 Đường ABC, Thành Phố XYZ</p>"
                + "<p>Số Điện Thoại: 0123456789</p>"
                +"<p>Gmail Công ty:B.Travel@gmail.com </p>"
                + "</div>"
                + "<div class=\"customer-info\">"
                + "<p><strong>Khách Hàng:</strong> " + name + "</p>"
                + "<p><strong>Số Điện Thoại:</strong> " + sodienthoai + "</p>"
                + "<p><strong>Ngày Đặt Tour:</strong> " + bookingDate + "</p>"
                + "</div>"
                + "<p><strong>Chào Quý Khách,</strong></p>"
                + "<p>Chúng tôi xin gửi lời xin lỗi chân thành vì hiện tại chưa nhận được tiền thanh toán từ quý khách " +
                " cho đơn đặt tour gần đây. Chúng tôi đề nghị quý khách kiểm tra lại thông tin giao dịch chuyển khoản để  " +
                "đảm bảo rằng thông tin được cung cấp đúng với địa chỉ email mà chúng tôi đã gửi.</p>"
                + "<p>Nếu quý khách có bất kỳ thắc mắc nào hoặc cần thêm thông tin, xin vui lòng liên hệ với chúng tôi  " +
                "qua số điện thoại: 0912345678. Chúng tôi luôn sẵn sàng hỗ trợ quý khách.</p>"
                + "<p>Cảm ơn bạn đã đặt tour! Chúc bạn có 1 ngày vui vẻ.</p>"
                + "<p>Cảm ơn quý khách đã tin tưởng chúng tôi.</p>"
                + "<p style=\"text-align: right;\">Trân trọng,<br>Công ty B.Travel</p>"
                + "</div>"
                + "</body></html>";

    }

}