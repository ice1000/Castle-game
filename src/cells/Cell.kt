package cells

open class Cell {
    public  var name: String

    internal constructor(name: String) {
        //		super();
        this.name = name
    }

    constructor() {
        name = "unKown"
    }
}
