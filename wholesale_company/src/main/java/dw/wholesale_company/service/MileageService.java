package dw.wholesale_company.service;

import dw.wholesale_company.model.Mileage;
import dw.wholesale_company.repository.MileageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class MileageService {
    MileageRepository mileageRepository;

    @Autowired
    public MileageService(MileageRepository mileageRepository) {
        this.mileageRepository = mileageRepository;
    }

    @GetMapping("/mileages")
    public List<Mileage> getAllMileages() {
        return mileageRepository.findAll();
    }
}
