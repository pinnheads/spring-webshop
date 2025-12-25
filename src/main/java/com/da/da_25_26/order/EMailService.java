package com.da.da_25_26.order;

import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
public class EMailService {
  private static final Logger LOGGER = Logger.getLogger(EMailService.class.getName());

  public void sendEmail(Long userId) {
    LOGGER.info("Confirmation email sent to User ID: " + userId);
  }
}
