package com.thegoodseeds.seedsaversapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thegoodseeds.seedsaversapp.entities.SwapTransaction;

@Repository
public interface SwapTransactionRepository extends JpaRepository<SwapTransaction, Long> {

}
