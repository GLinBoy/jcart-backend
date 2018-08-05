package ir.sargoll.shop.service;

import ir.sargoll.shop.model.UserTransaction;
import ir.sargoll.shop.repository.UserTransactionRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserTransactionServiceImpl
        extends AbstractServiceImpl<UserTransaction, UserTransactionRepositoryApi>
        implements UserTransactionServiceApi {
}
