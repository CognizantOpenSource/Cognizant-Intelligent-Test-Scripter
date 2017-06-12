package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{D6F05DAE-7F99-4FE0-9432-D48CAC4BA16E}")
public abstract interface IComponentFolderFactory
  extends IBaseFactory
{
  @DISPID(8)
  @VTID(16)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject root();
  
  @DISPID(9)
  @VTID(17)
  public abstract String folderPath(int paramInt);
  
  @DISPID(10)
  @VTID(18)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject folderByPath(String paramString);
  
  @DISPID(11)
  @VTID(19)
  public abstract IList unattachedComponents();
  
  @VTID(19)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object unattachedComponents(int paramInt);
  
  @DISPID(12)
  @VTID(20)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject templates();
  
  @DISPID(13)
  @VTID(21)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject obsolete();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IComponentFolderFactory
 * JD-Core Version:    0.7.0.1
 */