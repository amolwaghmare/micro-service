package com.amol.payments.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.payments.data.entity.Transfer;

public interface TransferRepository extends JpaRepository <Transfer, Integer>{

}
