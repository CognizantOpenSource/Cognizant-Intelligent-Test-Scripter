package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.Holder;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{B7362C73-02EC-4AA1-8B15-46490ED301BC}")
public abstract interface ILicenseManager
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void getLicense(int paramInt);
  
  @DISPID(2)
  @VTID(8)
  public abstract void getLicenses(int paramInt, Holder<String> paramHolder);
  
  @DISPID(3)
  @VTID(9)
  public abstract void getLicenseStatus(int paramInt, Holder<Integer> paramHolder1, Holder<Integer> paramHolder2);
  
  @DISPID(4)
  @VTID(10)
  public abstract int edition();
  
  @DISPID(5)
  @VTID(11)
  public abstract IList deniedFeatures();
  
  @VTID(11)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object deniedFeatures(int paramInt);
  
  @DISPID(6)
  @VTID(12)
  public abstract boolean isFeatureEnabled(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ILicenseManager
 * JD-Core Version:    0.7.0.1
 */