package units.abstractUnits;

public interface ArenaInterface {
    void unit_turning();
    void rounding(); // использовать порядок инициативы
    void initiative();  // инициативу через массив?
    void unit_dying(); // когда хп = 0 то удалять из списка
    void target_choice();   //для атакующих и защищающих одновременно?
}
