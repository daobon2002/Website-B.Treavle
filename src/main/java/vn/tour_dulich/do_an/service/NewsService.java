package vn.tour_dulich.do_an.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.tour_dulich.do_an.Entity.NewsEntity;
import vn.tour_dulich.do_an.dto.NewsDto;
import vn.tour_dulich.do_an.repository.NewsRepository;
import vn.tour_dulich.do_an.service.Interface.interfaceNews;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class NewsService implements interfaceNews {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<NewsEntity> searchNews(String keyword) {
        return newsRepository.searchNewsEntitiesBy(keyword);
    }

    @Override
    public Page<NewsEntity> searchNews(String keyword, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        List<NewsEntity> list = searchNews(keyword);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());
        return new PageImpl<>(list.subList(start, end), pageable, list.size());
    }

    @Override
    public Page<NewsEntity> getNewsAll(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        return newsRepository.findAll(pageable);
    }


    public void createNews(NewsDto newsDto) {
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setTieude(newsDto.getTieude());
        newsEntity.setNoidung(newsDto.getNoidung());
        newsEntity.setAuthor(newsDto.getAuthor());
        newsEntity.setNgaydang(newsDto.getNgaydang());

        // Xử lý hình ảnh
        MultipartFile file = newsDto.getImage();
        if (file != null && !file.isEmpty()) {
            try {
                String filePath = "D:/bon/do_an/src/main/resources/static/image/" + file.getOriginalFilename();
                File destinationFile = new File(filePath);
                file.transferTo(destinationFile);
                newsEntity.setImage(file.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException("Lỗi khi lưu ảnh: " + e.getMessage(), e);
            }
        }

        newsRepository.save(newsEntity);
    }
    @Transactional
    public void deleteNewsById(Long id) {
        if (newsRepository.existsById(id)) {
            newsRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("News not found with id: " + id);
        }
    }
    @Transactional
    public void updateNews(Long id, NewsDto newsDto) {
        NewsEntity newsEntity = newsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tin tức không tồn tại với ID: " + id));

        // Cập nhật thông tin tin tức
        newsEntity.setTieude(newsDto.getTieude());
        newsEntity.setNoidung(newsDto.getNoidung());
        newsEntity.setAuthor(newsDto.getAuthor());
        newsEntity.setNgaydang(newsDto.getNgaydang());

        // Xử lý hình ảnh (nếu có)
        MultipartFile file = newsDto.getImage();
        if (file != null && !file.isEmpty()) {
            try {
                String filePath = "D:/bon/do_an/src/main/resources/static/image/" + file.getOriginalFilename();
                File destinationFile = new File(filePath);
                file.transferTo(destinationFile);
                newsEntity.setImage(file.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException("Lỗi khi lưu ảnh: " + e.getMessage(), e);
            }
        }

        newsRepository.save(newsEntity); // Lưu tin tức đã cập nhật
    }
    public NewsDto getNewsById(Long id) {
        NewsEntity newsEntity = newsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("News not found with id: " + id));
        NewsDto newsDto = new NewsDto();
        newsDto.setId(newsEntity.getId());
        newsDto.setTieude(newsEntity.getTieude());
        newsDto.setNoidung(newsEntity.getNoidung());
        newsDto.setAuthor(newsEntity.getAuthor());
        newsDto.setNgaydang(newsEntity.getNgaydang());
        return newsDto;
    }
}
