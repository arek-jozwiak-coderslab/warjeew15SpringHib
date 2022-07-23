package pl.coderslab.dwarfs;

import org.springframework.stereotype.Service;

@Service
public class DwarfService {
    private final DwarfDao dwarfDao;

    public DwarfService(DwarfDao dwarfDao) {
        this.dwarfDao = dwarfDao;
    }

    public void save(Dwarf dwarf) {
        // some logic
        dwarfDao.save(dwarf);
        // some logic
    }
    public Dwarf findById(Long id){
        return dwarfDao.findById(id);
    }

}
