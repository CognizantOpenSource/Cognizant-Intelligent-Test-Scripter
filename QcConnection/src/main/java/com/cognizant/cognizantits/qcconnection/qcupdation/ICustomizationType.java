package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{EB345576-4831-4653-816F-791478BFE555}")
public abstract interface ICustomizationType
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int id();
  
  @DISPID(2)
  @VTID(8)
  public abstract String name();
  
  @DISPID(2)
  @VTID(9)
  public abstract void name(String paramString);
  
  @DISPID(3)
  @VTID(10)
  public abstract IList fields();
  
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object fields(int paramInt);
  
  @DISPID(4)
  @VTID(11)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject field(String paramString);
  
  @DISPID(5)
  @VTID(12)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addField(String paramString);
  
  @DISPID(6)
  @VTID(13)
  public abstract void removeField(String paramString);
  
  @DISPID(7)
  @VTID(14)
  public abstract IStream icon();
  
  @DISPID(7)
  @VTID(15)
  public abstract void icon(IStream paramIStream);
  
  @DISPID(8)
  @VTID(16)
  public abstract String editingControl();
  
  @DISPID(8)
  @VTID(17)
  public abstract void editingControl(String paramString);
  
  @DISPID(9)
  @VTID(18)
  public abstract String prefix();
  
  @DISPID(9)
  @VTID(19)
  public abstract void prefix(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationType
 * JD-Core Version:    0.7.0.1
 */