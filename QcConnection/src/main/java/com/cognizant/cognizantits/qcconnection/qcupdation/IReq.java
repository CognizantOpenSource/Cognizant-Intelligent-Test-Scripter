package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{4592C936-2524-4D05-9978-95901EDE0A54}")
public abstract interface IReq
  extends IBaseFieldExMail
{
  @DISPID(15)
  @VTID(24)
  public abstract String name();
  
  @DISPID(15)
  @VTID(25)
  public abstract void name(String paramString);
  
  @DISPID(16)
  @VTID(26)
  public abstract String comment();
  
  @DISPID(16)
  @VTID(27)
  public abstract void comment(String paramString);
  
  @DISPID(17)
  @VTID(28)
  public abstract String product();
  
  @DISPID(17)
  @VTID(29)
  public abstract void product(String paramString);
  
  @DISPID(18)
  @VTID(30)
  public abstract String type();
  
  @DISPID(18)
  @VTID(31)
  public abstract void type(String paramString);
  
  @DISPID(19)
  @VTID(32)
  public abstract String author();
  
  @DISPID(19)
  @VTID(33)
  public abstract void author(String paramString);
  
  @DISPID(20)
  @VTID(34)
  public abstract int count();
  
  @DISPID(21)
  @VTID(35)
  public abstract String priority();
  
  @DISPID(21)
  @VTID(36)
  public abstract void priority(String paramString);
  
  @DISPID(22)
  @VTID(37)
  public abstract String status();
  
  @DISPID(23)
  @VTID(38)
  public abstract String reviewed();
  
  @DISPID(23)
  @VTID(39)
  public abstract void reviewed(String paramString);
  
  @DISPID(24)
  @VTID(40)
  public abstract int addCoverage(int paramInt1, int paramInt2);
  
  @DISPID(25)
  @VTID(41)
  public abstract int addCoverageEx(int paramInt1, int paramInt2);
  
  @DISPID(26)
  @VTID(42)
  public abstract void removeCoverage(@MarshalAs(NativeType.VARIANT) Object paramObject, @Optional @DefaultValue("0") boolean paramBoolean);
  
  @DISPID(27)
  @VTID(43)
  public abstract IList getCoverList(@Optional @DefaultValue("0") boolean paramBoolean);
  
  @DISPID(28)
  @VTID(44)
  public abstract String paragraph();
  
  @DISPID(29)
  @VTID(45)
  public abstract String path();
  
  @DISPID(30)
  @VTID(46)
  public abstract boolean hasCoverage();
  
  @DISPID(31)
  @VTID(47)
  public abstract void move(int paramInt1, int paramInt2);
  
  @DISPID(32)
  @VTID(48)
  public abstract boolean isFolder();
  
  @DISPID(32)
  @VTID(49)
  public abstract void isFolder(boolean paramBoolean);
  
  @DISPID(33)
  @VTID(50)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject reqSummaryStatus();
  
  @DISPID(34)
  @VTID(51)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject reqCoverageStatus();
  
  @DISPID(35)
  @VTID(52)
  public abstract int addCoverageByFilter(int paramInt1, int paramInt2, String paramString);
  
  @DISPID(36)
  @VTID(53)
  public abstract IList getCoverListByFilter(String paramString, @Optional @DefaultValue("0") boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IReq
 * JD-Core Version:    0.7.0.1
 */