package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.DefaultValue;
import com4j.Holder;
import com4j.IID;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{BF9B38B0-935B-4112-92EC-49FED46AC64D}")
public abstract interface IExtendedStorage
  extends Com4jObject
{
  @DISPID(0)
  @VTID(7)
  @DefaultMethod
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject root();
  
  @DISPID(1)
  @VTID(8)
  public abstract String load(@Optional @DefaultValue("*.*") String paramString, @Optional @DefaultValue("0") boolean paramBoolean);
  
  @DISPID(2)
  @VTID(9)
  public abstract void save(@Optional @DefaultValue("*.*") String paramString, @Optional @DefaultValue("0") boolean paramBoolean);
  
  @DISPID(3)
  @VTID(10)
  public abstract void delete(String paramString, int paramInt);
  
  @DISPID(4)
  @VTID(11)
  public abstract String serverPath();
  
  @DISPID(4)
  @VTID(12)
  public abstract void serverPath(String paramString);
  
  @DISPID(5)
  @VTID(13)
  public abstract String clientPath();
  
  @DISPID(5)
  @VTID(14)
  public abstract void clientPath(String paramString);
  
  @DISPID(6)
  @VTID(15)
  public abstract void cancel();
  
  @DISPID(7)
  @VTID(16)
  public abstract int actionFinished();
  
  @DISPID(8)
  @VTID(17)
  public abstract String progress(Holder<Integer> paramHolder1, Holder<Integer> paramHolder2);
  
  @DISPID(9)
  @VTID(18)
  public abstract void getLastError();
  
  @DISPID(10)
  @VTID(19)
  public abstract boolean saveEx(String paramString, boolean paramBoolean, Holder<IList> paramHolder);
  
  @DISPID(11)
  @VTID(20)
  public abstract String loadEx(String paramString, boolean paramBoolean, Holder<IList> paramHolder, Holder<Boolean> paramHolder1);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IExtendedStorage
 * JD-Core Version:    0.7.0.1
 */