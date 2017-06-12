package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.Holder;
import com4j.IID;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Date;

@IID("{613E9BF2-7888-438F-979F-D05DAB87B9C8}")
public abstract interface IAttachment
  extends IBaseField
{
  @DISPID(11)
  @VTID(20)
  public abstract int type();
  
  @DISPID(11)
  @VTID(21)
  public abstract void type(int paramInt);
  
  @DISPID(12)
  @VTID(22)
  public abstract String name(@Optional @DefaultValue("0") int paramInt);
  
  @DISPID(13)
  @VTID(23)
  public abstract String description();
  
  @DISPID(13)
  @VTID(24)
  public abstract void description(String paramString);
  
  @DISPID(14)
  @VTID(25)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object data();
  
  @DISPID(15)
  @VTID(26)
  public abstract String fileName();
  
  @DISPID(15)
  @VTID(27)
  public abstract void fileName(String paramString);
  
  @DISPID(16)
  @VTID(28)
  public abstract void load(boolean paramBoolean, Holder<String> paramHolder);
  
  @DISPID(17)
  @VTID(29)
  public abstract void save(boolean paramBoolean);
  
  @DISPID(18)
  @VTID(30)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject attachmentStorage();
  
  @DISPID(19)
  @VTID(31)
  public abstract String directLink();
  
  @DISPID(20)
  @VTID(32)
  public abstract String serverFileName();
  
  @DISPID(21)
  @VTID(33)
  public abstract int fileSize();
  
  @DISPID(22)
  @VTID(34)
  public abstract Date lastModified();
  
  @DISPID(23)
  @VTID(35)
  public abstract void rename(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAttachment
 * JD-Core Version:    0.7.0.1
 */