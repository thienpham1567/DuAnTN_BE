package shoesShop.common.Size;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;

@Service
public class SizeService extends RecordManager<Size> {
	@Autowired
	ISizeRepository sizeRepo;

	SizeConverter converter = new SizeConverter();

	@Override
	public Collection<Size> retrieveAll() {
		Collection<Size> sizes = this.load(null).stream().map(dbSize -> this.converter.convertDbToModel(dbSize))
				.collect(Collectors.toList());
		return sizes;
	}

	private Collection<DbSize> load(Integer sizeId) {
		Collection<DbSize> dbSizes = this.sizeRepo.findAll();

		if (sizeId != null) {
			dbSizes = dbSizes.stream().filter(dbSize -> dbSize.sizeId == sizeId).collect(Collectors.toList());
		}

		return dbSizes;
	}
}
