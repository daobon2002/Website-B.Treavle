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
import vn.tour_dulich.do_an.Entity.CategoryEntity;
import vn.tour_dulich.do_an.dto.CategoryDto;
import vn.tour_dulich.do_an.repository.CategotyRepository;
import vn.tour_dulich.do_an.service.Interface.interfaceCategory;
import java.util.List;

@Service
public class CategotyService implements interfaceCategory {

    @Autowired
    CategotyRepository categotyRepository;

    public List<CategoryEntity> getAll(){
        return categotyRepository.findAll();
    }


    @Override
    public List<CategoryEntity> searchCategory(String keyword) {
        return categotyRepository.searchCategoryEntitiesBy(keyword);
    }

    @Override
    public Page<CategoryEntity> getCategoryAll(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        return categotyRepository.findAll(pageable);
    }

    @Override
    public Page<CategoryEntity> searchCategory(String keyword, Integer pageNumber) {
        List<CategoryEntity> list = this.searchCategory(keyword);
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());
        list = list.subList(start, end);
        return new PageImpl<>(list, pageable, this.searchCategory(keyword).size());
    }
    public void saveCategory(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setTentheloai(categoryDto.getTentheloai());
        categotyRepository.save(categoryEntity);
    }
    public CategoryDto getCategoryDtoById(Long id) {
        CategoryEntity categoryEntity = categotyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
        return convertToDto(categoryEntity);
    }

    private CategoryDto convertToDto(CategoryEntity categoryEntity) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(categoryEntity.getId());
        categoryDto.setTentheloai(categoryEntity.getTentheloai());
        // Nếu có thêm thuộc tính nào khác, bạn có thể thêm vào đây
        return categoryDto;
    }

    @Transactional
    public void updateCategory(Long id, @Valid CategoryDto categoryDto) {
        CategoryEntity categoryEntity = categotyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
        categoryEntity.setTentheloai(categoryDto.getTentheloai());
        // Cập nhật các thuộc tính khác nếu có
        categotyRepository.save(categoryEntity);
    }
    public void deleteById(Long id) {
        categotyRepository.deleteById(id);
    }
}
