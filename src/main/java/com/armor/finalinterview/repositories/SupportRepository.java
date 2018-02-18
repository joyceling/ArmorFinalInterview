package com.armor.finalinterview.repositories;

import com.armor.finalinterview.models.SupportTicket;
import org.springframework.data.repository.CrudRepository;

public interface SupportRepository extends CrudRepository<SupportTicket, Long> {

}
