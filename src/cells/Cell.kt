package cells

open class Cell {
    private var name: String

    internal constructor(name: String) {
        //		super();
        this.name = name
    }

    constructor() {
        name = "unKown"
    }
    public fun setName(name: String){
        this.name = name
    }
}
