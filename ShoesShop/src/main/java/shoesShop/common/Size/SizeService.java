package shoesShop.common.Size;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Category.ICategoryRepository;

@Service
public class SizeService extends RecordManager<Size> {
	@Autowired
	private ISizeRepository sizeRepo;

	SizeConverter converter = new SizeConverter();
	@Autowired
	private ICategoryRepository categoryRepo;

	@Override
	public Collection<Size> retrieveAll() {
		Collection<Size> sizes = this.load(null).stream().map(dbSize -> this.converter.convertDbToModel(dbSize))
				.collect(Collectors.toList());
		return sizes;
	}
	
	@Override
	public Size retrieveOne(Integer id) throws Exception {
		Size size = this.load(id).stream().map(dbSize -> this.converter.convertDbToModel(dbSize)).findFirst().get();
		return size;
	}
	
//	@Override
//	public Size create(Size size) throws Exception {
//		System.out.println(size.getValue());
//		System.out.println(size.getCategoryId());
//		
//		DbSize dbSize = this.converter.convertModelToDb(size);
//		
//		dbSize.category = this.categoryRepo.findById(size.categoryId).get();
//		DbSize createdSize = this.sizeRepo.save(dbSize);
//		
//		return this.converter.convertDbToModel(createdSize);
//	}
//
//	@Override
//	public Size update(Size size, Integer id) throws Exception {
//		DbSize updateSize = this.converter.convertModelToDb(size);
//		DbSize dbSize = this.sizeRepo.findById(id).get();
//		if (dbSize != null) {
//			this.converter.combine(dbSize, updateSize);
//			DbSize updateDbSize = this.sizeRepo.save(dbSize);
//			return this.converter.convertDbToModel(updateDbSize);
//		}
//		return size;
//	}
//	
//	@Override
//	public Boolean delete(Integer id) throws Exception {
//		if (this.sizeRepo.existsById(id)) {
//			this.sizeRepo.deleteById(id);
//			return true;
//		}
//		return false;
//	}

	private Collection<DbSize> load(Integer sizeId) {
		Collection<DbSize> dbSizes = this.sizeRepo.findAll();
		if (sizeId != null) {
			dbSizes = dbSizes.stream().filter(dbSize -> dbSize.sizeId == sizeId).collect(Collectors.toList());
		}
		return dbSizes;
	}
}
