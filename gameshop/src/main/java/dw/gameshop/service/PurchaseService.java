package dw.gameshop.service;

import dw.gameshop.exception.ResourceNotFoundException;
import dw.gameshop.model.Purchase;
import dw.gameshop.model.User;
import dw.gameshop.repository.GameInfoRepository;
import dw.gameshop.repository.PurchaseRepository;
import dw.gameshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;
    UserRepository userRepository;
    public  Purchase savePurchase(Purchase purchase){
        // 구매확정 바로 직전, 현재 시간 저장
        purchase.setPurchaseTime(LocalDateTime.now());
        return purchaseRepository.save(purchase);
    }
    public List<Purchase> getAllpurchases(){
        return purchaseRepository.findAll();
    }
    public List<Purchase> getPurchaseListByUser(String userId){
        // userId로 user객체 찾기
        Optional<User> userOptional  = userRepository.findByUserId(userId);
        if (userOptional.isEmpty()){
            throw new ResourceNotFoundException("User", "ID", userId);
        }
        return purchaseRepository.findByUser(userOptional.get());
    }
}
