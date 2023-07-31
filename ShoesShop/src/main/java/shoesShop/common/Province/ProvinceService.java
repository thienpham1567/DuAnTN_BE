package shoesShop.common.Province;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;

@Service
public class ProvinceService extends RecordManager<Province>{
	@Autowired
	IProvinceRepository provinceRepo;
	
	private ProvinceConverter converter = new ProvinceConverter();
	
	@Override
	public Collection<Province> retrieveAll() {
		Collection<Province> provinces = this.load(null).stream().map(dbProvince -> this.converter.convertDbToModel(dbProvince))
				.collect(Collectors.toList());
		return provinces;
	}

	@Override
	public Province retrieveOne(Integer id) throws Exception {
		Province province = this.load(id).stream().map(dbProvince -> this.converter.convertDbToModel(dbProvince)).findFirst().get();
		return province;
	}
	
	private Collection<DbProvince> load(Integer provinceId) {
		Collection<DbProvince> dbProvinces = this.provinceRepo.findAll();

		if (provinceId != null) {
			dbProvinces = dbProvinces.stream().filter(dbProvince -> dbProvince.provinceId == provinceId).collect(Collectors.toList());
		}

		return dbProvinces;
	}
}
