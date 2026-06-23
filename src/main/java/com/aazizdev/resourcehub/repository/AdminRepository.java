package com.aazizdev.resourcehub.repository;

import com.aazizdev.resourcehub.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {

}
