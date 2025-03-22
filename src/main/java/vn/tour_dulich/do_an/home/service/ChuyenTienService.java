package vn.tour_dulich.do_an.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.tour_dulich.do_an.Entity.CKEntity;
import vn.tour_dulich.do_an.home.resitory.ChuyenTienRepository;

import java.util.List;


@Service
public class ChuyenTienService {

    @Autowired
    ChuyenTienRepository chuyenTienRepository;
    public void saveChuyenTien(String noiDungChuyenKhoan, String soTienChuyenKhoan) {
        CKEntity chuyenTien = new CKEntity();
        chuyenTien.setNoidungchuyenkhoan(noiDungChuyenKhoan);
        chuyenTien.setSotienchuyenkhoan(soTienChuyenKhoan);
        chuyenTienRepository.save(chuyenTien);
    }

    public List<CKEntity> getLatestFiveTransfers() {
        return chuyenTienRepository.findTop5ByOrderByIdDesc(); // Lấy 5 bản ghi mới nhất
    }
}