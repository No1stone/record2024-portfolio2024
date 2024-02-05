package com.origemite.authserver.data.db.repo;

import com.origemite.authserver.data.db.entity.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TbUserRepo extends JpaRepository<TbUser, String> {
}
