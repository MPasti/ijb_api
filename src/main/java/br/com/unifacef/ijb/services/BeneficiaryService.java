package br.com.unifacef.ijb.services;


import br.com.unifacef.ijb.helpers.UserInfoHelper;
import br.com.unifacef.ijb.models.dtos.AuthorityDTO;
import br.com.unifacef.ijb.models.dtos.BeneficiaryRegisterDTO;
import br.com.unifacef.ijb.models.dtos.UserInfoCreateDTO;
import br.com.unifacef.ijb.models.entities.UserInfo;
import br.com.unifacef.ijb.models.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacef.ijb.models.entities.Beneficiary;
import br.com.unifacef.ijb.repositories.BeneficiaryRepository;

import java.time.LocalDateTime;

@Service
public class BeneficiaryService {
    @Autowired
    private BeneficiaryRepository repository;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private UserInfoService userInfoService;

    private Beneficiary save(Beneficiary beneficiary) {
        return repository.save(beneficiary);
    }

    public Beneficiary createBeneficiary(BeneficiaryRegisterDTO beneficiaryRegister) {
        AuthorityDTO authorityDTO = authorityService.findAuthorityRole(Role.ROLE_BENEFICIARIO);
        UserInfoCreateDTO userInfoCreateDTO = UserInfoHelper.setUpUserInfoCreateDTO(authorityDTO, beneficiaryRegister);
        UserInfo userInfo = userInfoService.createUserInfo(userInfoCreateDTO);

        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setUser(userInfo.getUser());
        beneficiary.setName(beneficiaryRegister.getName() + " " + beneficiaryRegister.getLastName());
        beneficiary.setCreatedAt(LocalDateTime.now());
        beneficiary.setUpdatedAt(LocalDateTime.now());
        beneficiary.setIndicationDate(LocalDateTime.now());
        beneficiary.setMeetDescription("Whatsapp");


        return save(beneficiary);
    }


//    public BeneficiaryDTO InsertBeneficiary(BeneficiaryDTO beneficiaryDTO){
//        Beneficiary entity = BeneficiaryMapper.convertBeneficiaryDTOIntoBeneficiary(beneficiaryDTO);
//        Beneficiary savedEntity = repository.save(entity);
//        return BeneficiaryMapper.convertBeneficiaryIntoBeneficiaryDTO(savedEntity);
//    }
//
//    public List<BeneficiaryDTO> findAllBeneficiaries(){
//        List<Beneficiary> beneficiary = repository.findAll();
//        return beneficiary.stream().map(convertBeneficiaryDTOIntoBeneficiary).collect(Collectors.toList());
//    }

}
