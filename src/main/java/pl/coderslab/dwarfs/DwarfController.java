package pl.coderslab.dwarfs;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dwarf")
public class DwarfController {

    private final DwarfDao dwarfDao;

    public DwarfController(DwarfDao dwarfDao) {
        this.dwarfDao = dwarfDao;
    }

    @RequestMapping("/create")
    @ResponseBody
    public String saveDwarf(){
        Dwarf dwarf = new Dwarf();
        dwarf.setName("Konstruktor");
        dwarfDao.save(dwarf);
        return "ok";
    }
}
