package vn.tour_dulich.do_an.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.tour_dulich.do_an.Entity.CategoryEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;
import vn.tour_dulich.do_an.Entity.UserEntity;
import vn.tour_dulich.do_an.dto.TourDto;
import vn.tour_dulich.do_an.repository.CategotyRepository;
import vn.tour_dulich.do_an.repository.TourRepository;
import vn.tour_dulich.do_an.service.Interface.interfaceTour;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class TourService implements interfaceTour {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private CategotyRepository categotyRepository; // Thêm repository cho loại tour

    // Phương thức lưu tour
    public void saveTour(TourDto tourDto) {
        TourEntity tourEntity = new TourEntity();
        tourEntity.setTentour(tourDto.getTentour());
        tourEntity.setMota(tourDto.getMota());
        tourEntity.setGia(tourDto.getGia());
        tourEntity.setNgaykhoihanh(tourDto.getNgaykhoihanh());
        tourEntity.setPhuongtien(tourDto.getPhuongtien());
        tourEntity.setLichtrinh(tourDto.getLichtrinh());
        tourEntity.setSoday(tourDto.getSoday());
        tourEntity.setUudai(tourDto.getUudai());
        tourEntity.setDiadiem(tourDto.getDiadiem());
        tourEntity.setSoluongghe(tourDto.getSoluongghe());

        // Xử lý file ảnh
        MultipartFile file = tourDto.getImage();
        if (file != null && !file.isEmpty()) {
            try {
                String filePath = "D:/bon/do_an/src/main/resources/static/image/" + file.getOriginalFilename();
                File destinationFile = new File(filePath);
                file.transferTo(destinationFile);
                tourEntity.setImage(file.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException("Lỗi khi lưu ảnh: " + e.getMessage(), e);
            }
        }

        // Thiết lập loại tour
        if (tourDto.getLoaitourId() != null) {
            Optional<CategoryEntity> categoryOptional = categotyRepository.findById(tourDto.getLoaitourId());
            CategoryEntity category = categoryOptional.orElseThrow(() ->
                    new RuntimeException("Loại tour không tồn tại với ID: " + tourDto.getLoaitourId())
            );
            tourEntity.setCategory(category);
        }

        // Lưu tour
        tourRepository.save(tourEntity);
    }
    public void updateTour(TourDto tourDto) {
        TourEntity tourEntity = tourRepository.findById(tourDto.getId())
                .orElseThrow(() -> new RuntimeException("Tour không tồn tại với ID: " + tourDto.getId()));

        tourEntity.setTentour(tourDto.getTentour());
        tourEntity.setMota(tourDto.getMota());
        tourEntity.setGia(tourDto.getGia());
        tourEntity.setNgaykhoihanh(tourDto.getNgaykhoihanh());
        tourEntity.setPhuongtien(tourDto.getPhuongtien());
        tourEntity.setLichtrinh(tourDto.getLichtrinh());
        tourEntity.setSoday(tourDto.getSoday());
        tourEntity.setUudai(tourDto.getUudai());
        tourEntity.setDiadiem(tourDto.getDiadiem());
        tourEntity.setSoluongghe(tourDto.getSoluongghe());

        // Xử lý file ảnh (nếu có)
        MultipartFile file = tourDto.getImage();
        if (file != null && !file.isEmpty()) {
            try {
                String filePath = "D:/bon/do_an/src/main/resources/static/image/" + file.getOriginalFilename();
                File destinationFile = new File(filePath);
                file.transferTo(destinationFile);
                tourEntity.setImage(file.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException("Lỗi khi lưu ảnh: " + e.getMessage(), e);
            }
        }

        // Thiết lập loại tour
        if (tourDto.getLoaitourId() != null) {
            Optional<CategoryEntity> categoryOptional = categotyRepository.findById(tourDto.getLoaitourId());
            CategoryEntity category = categoryOptional.orElseThrow(() ->
                    new RuntimeException("Loại tour không tồn tại với ID: " + tourDto.getLoaitourId())
            );
            tourEntity.setCategory(category);
        }

        // Lưu tour
        tourRepository.save(tourEntity);
    }
    public TourDto findById(Long id) {
        Optional<TourEntity> tourEntityOpt = tourRepository.findById(id);

        // Kiểm tra nếu tourEntityOpt có giá trị
        if (tourEntityOpt.isPresent()) {
            TourEntity tourEntity = tourEntityOpt.get();
            TourDto tourDto = new TourDto();
            tourDto.setId(tourEntity.getId());
            tourDto.setTentour(tourEntity.getTentour());
            tourDto.setMota(tourEntity.getMota());
            tourDto.setGia(tourEntity.getGia());
            tourDto.setLichtrinh(tourEntity.getLichtrinh());
            tourDto.setNgaykhoihanh(tourEntity.getNgaykhoihanh());
            tourDto.setPhuongtien(tourEntity.getPhuongtien());
            tourDto.setLichtrinh(tourEntity.getLichtrinh());
            tourDto.setUudai(tourEntity.getUudai());
            tourDto.setSoday(tourEntity.getSoday());
            tourDto.setDiadiem(tourEntity.getDiadiem());
            tourDto.setSoluongghe(tourEntity.getSoluongghe());

            return tourDto;
        } else {
            throw new RuntimeException("Không tìm thấy tour với ID: " + id);
        }
    }
    public void deleteTour(Long id) {
        // Kiểm tra nếu tour tồn tại
        TourEntity tourEntity = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour không tồn tại với ID: " + id));
        // Xóa tour
        tourRepository.delete(tourEntity);
    }

    @Override
    public List<TourEntity> searchTour(String keyword) {
        return tourRepository.searchBy(keyword);
    }

    @Override
    public Page<TourEntity> getAll(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        return tourRepository.findAll(pageable);
    }

    @Override
    public Page<TourEntity> searchTour(String keyword, Integer pageNumber) {
        List<TourEntity> list = this.searchTour(keyword);
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());
        list = list.subList(start, end);
        return new PageImpl<>(list, pageable, this.searchTour(keyword).size());
    }
    public Optional<TourEntity> getTourById(Long tourId) {
        return tourRepository.findById(tourId); // Giả định tourRepository kế thừa JpaRepository
    }
    public TourEntity findTourByName(String tourName) {
        return tourRepository.findByTentour(tourName); // Gọi tới phương thức đã thêm vào TourRepository
    }


}