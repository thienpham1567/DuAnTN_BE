package shoesShop.common.OrderLine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportByBrandServiceImpl implements IReportByBrandService{
	@Autowired
	IOrderLineRepository repo;

	@Override
	public List<Object[]> getReportByBrands() {
		return repo.getReportByBrands();
	}
	
	
}
