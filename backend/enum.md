Un enum es una clase especial que representa un conjunto de valores constantes.

No son solo constantes… sino son objetos reales

Ejemplo:


public enum ErrorCode { 
  BAD_REQUEST(400, "ERR_400", "Bad Request"), 
  NOT_FOUND(404, "ERR_404", "Not Found"); 
  
  private final int status; 
  private final String code; 
  private final String description; 
  
  ErrorCode(int status, String code, String description) { 
    this.status = status; 
    this.code = code; 
    this.description = description; 
    
    } 
    
  public static ErrorCode fromStatus(int status) {
     for (ErrorCode e : values()) { 
      if (e.status == status) return e; 
      } return null; 
      } 
      
      }