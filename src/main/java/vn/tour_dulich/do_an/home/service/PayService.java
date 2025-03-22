package vn.tour_dulich.do_an.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tour_dulich.do_an.Entity.BooktourEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;
import vn.tour_dulich.do_an.home.resitory.HomeTourRepository;
import vn.tour_dulich.do_an.home.resitory.PayRepository;

import java.util.Optional;

@Service
public class PayService {
    @Autowired
    PayRepository payRepository;

    @Autowired
    HomeTourRepository homeTourRepository;

    public BooktourEntity getLatestBooking() {
        return payRepository.findTopByOrderByIdDesc();
    }
    public Optional<TourEntity> getAnyTour() {
        return homeTourRepository.findOneRandomTour();
    }


}
