package shoesShop.common.Ward;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import shoesShop.common.RecordManager;

public class WardService extends RecordManager<Ward>{
	@Autowired
	IWardRepository wardRepo;
	
	private WardConverter converter = new WardConverter();
	
	@Override
	public Collection<Ward> retrieveAll() {
		Collection<Ward> wards = this.load(null).stream().map(dbWard -> this.converter.convertDbToModel(dbWard))
				.collect(Collectors.toList());
		return wards;
	}

	@Override
	public Ward retrieveOne(Integer id) throws Exception {
		Ward ward = this.load(id).stream().map(dbProvince -> this.converter.convertDbToModel(dbProvince)).findFirst().get();
		return ward;
	}
	
	private Collection<DbWard> load(Integer wardId) {
		Collection<DbWard> dbWards = this.wardRepo.findAll();

		if (wardId != null) {
			dbWards = dbWards.stream().filter(dbProvince -> dbProvince.wardId == wardId).collect(Collectors.toList());
		}

		return dbWards;
	}
}
