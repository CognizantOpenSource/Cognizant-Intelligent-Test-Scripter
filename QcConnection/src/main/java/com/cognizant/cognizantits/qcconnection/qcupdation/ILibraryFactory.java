package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{8C7F6E7D-5596-4429-A9E6-075ABABF9F8B}")
public abstract interface ILibraryFactory
  extends IBaseFactoryEx
{
  @DISPID(9)
  @VTID(17)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addImportedItem(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(10)
  @VTID(18)
  public abstract IList libraryPartsEntitiesTables();
  
  @VTID(18)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object libraryPartsEntitiesTables(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ILibraryFactory
 * JD-Core Version:    0.7.0.1
 */