package shoesShop.common.Address;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Brand.Brand;
import shoesShop.common.Brand.DbBrand;

@Service
public class AddressService extends RecordManager<Address>{
	@Autowired
	IAddressRepository addressRepo;
	
	private AddressConverter converter = new AddressConverter();
	
	@Override
	public Collection<Address> retrieveAll() {
		Collection<Address> addresss = this.load(null).stream().map(dbDistrict -> this.converter.convertDbToModel(dbDistrict))
				.collect(Collectors.toList());
		return addresss;
	}

	@Override
	public Address retrieveOne(Integer id) throws Exception {
		Address address = this.load(id).stream().map(dbAddress -> this.converter.convertDbToModel(dbAddress)).findFirst().get();
		return address;
	}
	
	@Override
	public Address create(Address address) throws Exception {
		DbAddress dbAddress = this.converter.convertModelToDb(address);
		DbAddress createdAddress = this.addressRepo.save(dbAddress);
		return this.converter.convertDbToModel(createdAddress);
	}

	@Override
	public Address update(Address address, Integer id) throws Exception {
		DbAddress updateAddress = this.converter.convertModelToDb(address);
		DbAddress dbAddress = this.addressRepo.findById(id).get();
		if (dbAddress != null) {
			this.converter.combine(dbAddress, updateAddress);
			DbAddress updateDbAddress = this.addressRepo.save(dbAddress);
			return this.converter.convertDbToModel(updateDbAddress);
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) throws Exception {
		if (this.addressRepo.existsById(id)) {
			this.addressRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	private Collection<DbAddress> load(Integer addressId) {
		Collection<DbAddress> dbAddresses = this.addressRepo.findAll();

		if (addressId != null) {
			dbAddresses = dbAddresses.stream().filter(dbAddress -> dbAddress.addressId == addressId).collect(Collectors.toList());
		}

		return dbAddresses;
	}
}
