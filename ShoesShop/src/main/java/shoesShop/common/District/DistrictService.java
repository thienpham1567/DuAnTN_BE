package shoesShop.common.District;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;

@Service
public class DistrictService extends RecordManager<District>{
	@Autowired
	IDistrictRepository districtRepo;
	
	private DistrictConverter converter = new DistrictConverter();
	
	@Override
	public Collection<District> retrieveAll() {
		Collection<District> districts = this.load(null).stream().map(dbDistrict -> this.converter.convertDbToModel(dbDistrict))
				.collect(Collectors.toList());
		return districts;
	}

	@Override
	public District retrieveOne(Integer id) throws Exception {
		District district = this.load(id).stream().map(dbProvince -> this.converter.convertDbToModel(dbProvince)).findFirst().get();
		return district;
	}
	
	private Collection<DbDistrict> load(Integer districtId) {
		Collection<DbDistrict> dbDistricts = this.districtRepo.findAll();

		if (districtId != null) {
			dbDistricts = dbDistricts.stream().filter(dbDistrict -> dbDistrict.districtId == districtId).collect(Collectors.toList());
		}

		return dbDistricts;
	}
}
