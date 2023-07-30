package shoesShop.common.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaportTopUserServiceImpl implements IReportTopUserService{
	@Autowired
	IOrderRepository repo;
	
	@Override
	public List<Object[]> getTopUser() {
		return repo.getReportTopUser();
	}
	
}
