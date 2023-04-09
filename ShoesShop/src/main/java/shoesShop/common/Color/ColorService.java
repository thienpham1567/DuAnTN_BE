package shoesShop.common.Color;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;

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

	private Collection<DbColor> load(Integer colorId) {
		Collection<DbColor> dbColors = this.colorRepo.findAll();

		if (colorId != null) {
			dbColors = dbColors.stream().filter(dbSize -> dbSize.colorId == colorId).collect(Collectors.toList());
		}

		return dbColors;
	}
}
