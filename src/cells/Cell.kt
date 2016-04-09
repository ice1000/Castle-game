package cells

open class Cell {
    var name = ""
        internal set
    internal constructor(name: String) {
        //		super();
        this.name = name
    }
    constructor() {
        name = "unKown"
    }
}
