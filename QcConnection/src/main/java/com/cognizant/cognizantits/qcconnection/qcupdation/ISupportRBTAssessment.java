package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{7D7FDD57-E6B0-4CD5-BB97-0D2DFFD2DD70}")
public abstract interface ISupportRBTAssessment
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int biChosenAnswerForQuestion(int paramInt);
  
  @DISPID(1)
  @VTID(8)
  public abstract void biChosenAnswerForQuestion(int paramInt1, int paramInt2);
  
  @DISPID(2)
  @VTID(9)
  public abstract void assessBILevel();
  
  @DISPID(3)
  @VTID(10)
  public abstract String assessedBILevel();
  
  @DISPID(4)
  @VTID(11)
  public abstract boolean useCustomBILevel();
  
  @DISPID(4)
  @VTID(12)
  public abstract void useCustomBILevel(boolean paramBoolean);
  
  @DISPID(5)
  @VTID(13)
  public abstract String customBILevel();
  
  @DISPID(5)
  @VTID(14)
  public abstract void customBILevel(String paramString);
  
  @DISPID(6)
  @VTID(15)
  public abstract String effectiveBILevel();
  
  @DISPID(11)
  @VTID(16)
  public abstract int fpChosenAnswerForQuestion(int paramInt);
  
  @DISPID(11)
  @VTID(17)
  public abstract void fpChosenAnswerForQuestion(int paramInt1, int paramInt2);
  
  @DISPID(12)
  @VTID(18)
  public abstract void assessFPLevel();
  
  @DISPID(13)
  @VTID(19)
  public abstract String assessedFPLevel();
  
  @DISPID(14)
  @VTID(20)
  public abstract boolean useCustomFPLevel();
  
  @DISPID(14)
  @VTID(21)
  public abstract void useCustomFPLevel(boolean paramBoolean);
  
  @DISPID(15)
  @VTID(22)
  public abstract String customFPLevel();
  
  @DISPID(15)
  @VTID(23)
  public abstract void customFPLevel(String paramString);
  
  @DISPID(16)
  @VTID(24)
  public abstract String effectiveFPLevel();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISupportRBTAssessment
 * JD-Core Version:    0.7.0.1
 */