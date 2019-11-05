export class Usuario{
    idUsuario:number;
    username:String;
    nombre:String;
    password:String;
    genero:String;
    edad:number;
    descripcion:String

    constructor (idUsuario:number,username:String,nombre:String,password:String,genero:String,edad:number,descripcion:String){
        this.IdUsuario=idUsuario;
        this.username=username;
        this.nombre=nombre;
        this.password=password;
        this.genero=genero;
        this.edad=edad;
        this.descripcion=descripcion;

    }

    public set IdUsuario(v : number) {
        this.idUsuario = v;
    }

    public set Username(v : String) {
        this.username = v;
    }

    public set Nombre(v : String) {
        this.nombre = v;
    }

    public set Password(v : String) {
        this.password = v;
    }

    public set Genero(v : String) {
        this.genero = v;
    }

    public set Edad(v : number) {
        this.edad = v;
    }

    public set Descripcion(v : String) {
        this.descripcion = v;
    }
    
}