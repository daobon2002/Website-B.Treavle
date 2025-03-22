package vn.tour_dulich.do_an.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tour_dulich.do_an.Entity.BooktourEntity;
import vn.tour_dulich.do_an.dto.BooktourDto;
import vn.tour_dulich.do_an.home.resitory.BookingRepository;
@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public void createBooking(BooktourDto booktourDto) {
        BooktourEntity booktourEntity = new BooktourEntity();
        booktourEntity.setHoten(booktourDto.getHoten());
        booktourEntity.setGmail(booktourDto.getGmail());
        booktourEntity.setSoluong(booktourDto.getSoluong());
        booktourEntity.setSodienthoai(booktourDto.getSodienthoai());
        booktourEntity.setNgaythanhtoan(booktourDto.getNgaythanhtoan());
        booktourEntity.setSotien(booktourDto.getSotien());
        booktourEntity.setTentour(booktourDto.getTentour());
        booktourEntity.setTrangthai(booktourDto.getTrangthai());
        booktourEntity.setId(booktourDto.getId());

        bookingRepository.save(booktourEntity);
    }


    private BooktourDto convertToDto(BooktourEntity booktourEntity) {
        BooktourDto booktourDto = new BooktourDto();
        booktourDto.setId(booktourEntity.getId());
        booktourDto.setHoten(booktourEntity.getHoten());
        booktourDto.setGmail(booktourEntity.getGmail());
        booktourDto.setSodienthoai(booktourEntity.getSodienthoai());
        booktourDto.setSoluong(booktourEntity.getSoluong());
        booktourDto.setSotien(booktourEntity.getSotien());
        booktourDto.setTentour(booktourEntity.getTentour());
        booktourDto.setNgaythanhtoan(booktourEntity.getNgaythanhtoan());
        booktourDto.setTrangthai(booktourEntity.getTrangthai());

        return booktourDto;
    }
}



