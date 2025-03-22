package vn.tour_dulich.do_an.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.tour_dulich.do_an.Entity.BooktourEntity;
import vn.tour_dulich.do_an.Entity.NewsEntity;
import vn.tour_dulich.do_an.dto.BooktourDto;
import vn.tour_dulich.do_an.dto.NewsDto;
import vn.tour_dulich.do_an.repository.BooktourRepository;
import vn.tour_dulich.do_an.service.Interface.interfaceBooktour;

import java.util.Optional;
import java.util.List;

@Service
public class BooktourService implements interfaceBooktour {
    @Autowired
    BooktourRepository booktourRepository;

    @Override
    public List<BooktourEntity> searchBooktour(String keyword) {
        return booktourRepository.searchBooktourEntitiesBy(keyword);
    }

    @Override
    public Page<BooktourEntity> getBooktourAll(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        return booktourRepository.findAll(pageable);
    }

    @Override
    public Page<BooktourEntity> searchBooktour(String keyword, Integer pageNumber) {
        List<BooktourEntity> list = this.searchBooktour(keyword);
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());
        list = list.subList(start, end);
        return new PageImpl<>(list, pageable, this.searchBooktour(keyword).size());
    }


    public BooktourDto getBooktourDtoById(Long id) {
        BooktourEntity booktourEntity = booktourRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booktour not found with id: " + id));
        return convertToDto(booktourEntity);
    }

    private BooktourDto convertToDto(BooktourEntity booktourEntity) {
        BooktourDto booktourDto = new BooktourDto();
        booktourDto.setId(booktourEntity.getId());
        booktourDto.setHoten(booktourEntity.getHoten());
        booktourDto.setGmail(booktourEntity.getGmail());
        booktourDto.setTentour(booktourEntity.getTentour());
        booktourDto.setSodienthoai(booktourEntity.getSodienthoai());
        booktourDto.setSoluong(booktourEntity.getSoluong());
        booktourDto.setSotien(booktourEntity.getSotien());
        booktourDto.setNgaythanhtoan(booktourEntity.getNgaythanhtoan());
        booktourDto.setTrangthai(booktourEntity.getTrangthai());

        return booktourDto;
    }


    @Transactional
    public void updateBooktour(Long id, @Valid BooktourEntity booktourDto) {
        BooktourEntity booktourEntity = booktourRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("News not found with id: " + id));
        booktourEntity.setHoten(booktourDto.getHoten());
        booktourEntity.setGmail(booktourDto.getGmail());
        booktourEntity.setTentour(booktourDto.getTentour());
        booktourEntity.setSodienthoai(booktourDto.getSodienthoai());
        booktourEntity.setSoluong(booktourDto.getSoluong());
        booktourEntity.setSotien(booktourDto.getSotien());
        booktourEntity.setNgaythanhtoan(booktourDto.getNgaythanhtoan());
        booktourEntity.setTrangthai(booktourDto.getTrangthai());
        booktourRepository.save(booktourEntity);
    }
    @Transactional
    public void updateStatus(Long id, String newStatus) {
        BooktourEntity booktour = booktourRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booktour không tồn tại với ID: " + id));
        booktour.setTrangthai(newStatus);
        booktourRepository.save(booktour);
    }


}