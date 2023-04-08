package shoesShop.common.Brand;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Product.Product;

@Service
public class BrandService extends RecordManager<Brand> {
	@Autowired
	private IBrandRepository brandRepo;

	BrandConverter converter = new BrandConverter();

	@Override
	public Collection<Brand> retrieveAll() {
		Collection<Brand> brands = this.load(null).stream().map(dbBrand -> this.converter.convertDbToModel(dbBrand))
				.collect(Collectors.toList());
		return brands;
	}

	@Override
	public Brand retrieveOne(Integer id) throws Exception {
		Brand brand = this.load(id).stream().map(dbBrand -> this.converter.convertDbToModel(dbBrand)).findFirst().get();
		return brand;
	}

	@Override
	public Brand create(Brand brand) throws Exception {
		DbBrand dbBrand = this.converter.convertModelToDb(brand);
		DbBrand createdBrand = this.brandRepo.save(dbBrand);
		return this.converter.convertDbToModel(createdBrand);
	}

	@Override
	public Brand update(Brand brand, Integer id) throws Exception {
		DbBrand updateBrand = this.converter.convertModelToDb(brand);
		DbBrand dbBrand = this.brandRepo.findById(id).get();
		if (dbBrand != null) {
			this.converter.combine(dbBrand, updateBrand);
			DbBrand updateDbBrand = this.brandRepo.save(dbBrand);
			return this.converter.convertDbToModel(updateDbBrand);
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) throws Exception {
		if (this.brandRepo.existsById(id)) {
			this.brandRepo.deleteById(id);
			return true;
		}
		return false;
	}

	private Collection<DbBrand> load(Integer brandId) {
		Collection<DbBrand> dbBrands = this.brandRepo.findAll();
		if (brandId != null) {
			dbBrands = dbBrands.stream().filter(dbBrand -> dbBrand.brandId == brandId).collect(Collectors.toList());
		}
		return dbBrands;
	}

}
