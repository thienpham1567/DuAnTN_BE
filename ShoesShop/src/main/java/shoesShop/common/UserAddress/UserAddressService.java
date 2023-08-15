package shoesShop.common.UserAddress;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Address.AddressService;
import shoesShop.common.Address.DbAddress;
import shoesShop.common.Address.IAddressRepository;
import shoesShop.common.User.DbUser;
import shoesShop.common.User.IUserRepository;
import shoesShop.common.User.UserSerivce;

@Service
public class UserAddressService extends RecordManager<UserAddress> {
	@Autowired
	IUserAddressRepository userAddressRepo;
	
	@Autowired
	IAddressRepository addressRepo;
	
	@Autowired
	IUserRepository userRepo;
	
	private UserAddressConverter converter = new UserAddressConverter();
	
	@Override
	public Collection<UserAddress> retrieveAll() {
		Collection<UserAddress> userAddresses = this.load(null).stream().map(dbUserAddress -> this.converter.convertDbToModel(dbUserAddress))
				.collect(Collectors.toList());
		return userAddresses;
	}

	@Override
	public UserAddress retrieveOne(Integer id) throws Exception {
		UserAddress userAddress = this.load(id).stream().map(dbUserAddress -> this.converter.convertDbToModel(dbUserAddress)).findFirst().get();
		return userAddress;
	}
	
	@Override
	public UserAddress create(UserAddress userAdress) throws Exception {
		DbUserAddress dbUserAddress = new DbUserAddress();
		DbAddress dbAddress = this.addressRepo.findById(userAdress.addressId).get();
		DbUser dbUser = this.userRepo.findById(userAdress.userId).get();
		dbUserAddress.address = dbAddress;
		dbUserAddress.user = dbUser;
		dbUserAddress.isDefault = userAdress.isDefault;
		DbUserAddress createdUserAddress = this.userAddressRepo.save(dbUserAddress);
		return this.converter.convertDbToModel(createdUserAddress);
	}

	@Override
	public UserAddress update(UserAddress userAddress, Integer id) throws Exception {
		DbUserAddress updateUserAddress = this.converter.convertModelToDb(userAddress);
		DbUserAddress dbUserAddress = this.userAddressRepo.findById(id).get();
		if (dbUserAddress != null) {
			this.converter.combine(dbUserAddress, updateUserAddress);
			DbUserAddress updateDbUserAddress = this.userAddressRepo.save(dbUserAddress);
			return this.converter.convertDbToModel(updateDbUserAddress);
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) throws Exception {
		if (this.userAddressRepo.existsById(id)) {
			this.userAddressRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	private Collection<DbUserAddress> load(Integer userAddressId) {
		Collection<DbUserAddress> dbUserAddresses = this.userAddressRepo.findAll();

		if (userAddressId != null) {
			dbUserAddresses = dbUserAddresses.stream().filter(dbUserAddress -> dbUserAddress.userAddressId == userAddressId).collect(Collectors.toList());
		}

		return dbUserAddresses;
	}
}
