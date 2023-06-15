package shoesShop.common.Color;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Brand.Brand;
import shoesShop.common.Brand.DbBrand;

@Service
public class ColorService extends RecordManager<Color>{
	@Autowired
	IColorRepository colorRepo;
	
	private ColorConverter converter = new ColorConverter();
	
	@Override
	public Collection<Color> retrieveAll() {
		Collection<Color> colors = this.load(null).stream().map(dbColor -> this.converter.convertDbToModel(dbColor))
				.collect(Collectors.toList());
		return colors;
	}

	@Override
	public Color retrieveOne(Integer id) throws Exception {
		Color color = this.load(id).stream().map(dbColor -> this.converter.convertDbToModel(dbColor)).findFirst().get();
		return color;
	}

	@Override
	public Color create(Color color) throws Exception {
		DbColor dbColor = this.converter.convertModelToDb(color);
		DbColor createdColor = this.colorRepo.save(dbColor);
		return this.converter.convertDbToModel(createdColor);
	}

	@Override
	public Color update(Color color, Integer id) throws Exception {
		DbColor updateColor = this.converter.convertModelToDb(color);
		DbColor dbColor = this.colorRepo.findById(id).get();
		if (dbColor != null) {
			this.converter.combine(dbColor, updateColor);
			DbColor updateDbColor = this.colorRepo.save(dbColor);
			return this.converter.convertDbToModel(updateDbColor);
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) throws Exception {
		if (this.colorRepo.existsById(id)) {
			this.colorRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	private Collection<DbColor> load(Integer colorId) {
		Collection<DbColor> dbColors = this.colorRepo.findAll();

		if (colorId != null) {
			dbColors = dbColors.stream().filter(dbSize -> dbSize.colorId == colorId).collect(Collectors.toList());
		}

		return dbColors;
	}
}
