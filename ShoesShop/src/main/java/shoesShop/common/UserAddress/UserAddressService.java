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
		Collection<UserAddress> userAddresses = this.load(null, null, null).stream().map(dbUserAddress -> this.converter.convertDbToModel(dbUserAddress))
				.collect(Collectors.toList());
		return userAddresses;
	}

	@Override
	public UserAddress retrieveOne(Integer id) throws Exception {
		UserAddress userAddress = this.load(id, null, null).stream().map(dbUserAddress -> this.converter.convertDbToModel(dbUserAddress)).findFirst().get();
		return userAddress;
	}
	
	@Override
	public UserAddress create(UserAddress userAddress) throws Exception {
		DbUserAddress dbUserAddress = this.converter.convertModelToDb(userAddress);
		DbAddress dbAddress = this.addressRepo.findById(userAddress.addressId).get();
		DbUser dbUser = this.userRepo.findById(userAddress.userId).get();
		dbUserAddress.address = dbAddress;
		dbUserAddress.user = dbUser;
		DbUserAddress createdUserAddress = this.userAddressRepo.save(dbUserAddress);
		return this.converter.convertDbToModel(createdUserAddress);
	}

	@Override
	public UserAddress update(UserAddress userAddress, Integer id) throws Exception {
		DbUserAddress updatedUserAddress = this.converter.convertModelToDb(userAddress);
		DbAddress dbAddress = this.addressRepo.findById(userAddress.addressId).get();
		DbUser dbUser = this.userRepo.findById(userAddress.userId).get();
		updatedUserAddress.address = dbAddress;
		updatedUserAddress.user = dbUser;
		DbUserAddress dbUserAddress = this.userAddressRepo.findById(id).get();
		if (dbUserAddress != null) {
			this.converter.combine(dbUserAddress, updatedUserAddress);
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
	
	public Collection<UserAddress> retrieveByUser(Integer userId) throws Exception {
		Collection<UserAddress> userAddresses = this.load(null, userId, null).stream().map(dbUserAddress -> this.converter.convertDbToModel(dbUserAddress)).collect(Collectors.toList());;
		return userAddresses;
	}
	
	public Collection<UserAddress> retrieveDefaultAddressByUser(Integer userId, Boolean isDefault) throws Exception {
		Collection<UserAddress> userAddresses = this.load(null, userId, isDefault).stream().map(dbUserAddress -> this.converter.convertDbToModel(dbUserAddress)).collect(Collectors.toList());;
		return userAddresses;
	}
	
	private Collection<DbUserAddress> load(Integer userAddressId, Integer userId, Boolean isDefault) {
		Collection<DbUserAddress> dbUserAddresses = this.userAddressRepo.findAll();

		if (userAddressId != null) {
			dbUserAddresses = dbUserAddresses.stream().filter(dbUserAddress -> dbUserAddress.userAddressId == userAddressId).collect(Collectors.toList());
		}
		
		if (userId != null) {
			dbUserAddresses = dbUserAddresses.stream().filter(dbUserAddress -> dbUserAddress.user.userId == userId).collect(Collectors.toList());
		}
		
		if (isDefault != null) {
			dbUserAddresses = dbUserAddresses.stream().filter(dbUserAddress -> dbUserAddress.isDefault == isDefault).collect(Collectors.toList());
		}

		return dbUserAddresses;
	}
}
