package com.is.format.database;


import com.is.format.xml.*;
import com.is.model.ComputerInfo;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DataBaseInputFormat {

    private String index;
    private String producer;
    private String diagonal;
    private String resolution;
    private String screenType;
    private String isTouchable;
    private String processor;
    private String coreNumber;
    private String frequency;
    private String RAM;
    private String diskSize;
    private String diskType;
    private String graphicCard;
    private String graphicCardMemory;
    private String operatingSystem;
    private String opticalDrive;

    public static DataBaseInputFormat convert(ComputerInfo computerInfo) {
        return new DataBaseInputFormat(
                computerInfo.getIndex(),
                computerInfo.getProducer(),
                computerInfo.getDiagonal(),
                computerInfo.getResolution(),
                computerInfo.getScreenType(),
                computerInfo.getIsTouchable(),
                computerInfo.getProcessor(),
                computerInfo.getCoreNumber(),
                computerInfo.getFrequency(),
                computerInfo.getRAM(),
                computerInfo.getDiskSize(),
                computerInfo.getDiskType(),
                computerInfo.getGraphicCard(),
                computerInfo.getGraphicCardMemory(),
                computerInfo.getOperatingSystem(),
                computerInfo.getOpticalDrive()
        );
    }

    public ComputerInfo toComputerInfo() {
        return new ComputerInfo(
                this.index,
                this.producer,
                this.diagonal,
                this.resolution,
                this.screenType,
                this.isTouchable,
                this.processor,
                this.coreNumber,
                this.frequency,
                this.RAM,
                this.diskSize,
                this.diskType,
                this.graphicCard,
                this.graphicCardMemory,
                this.operatingSystem,
                this.opticalDrive
        );
    }

    public static XMLInputFormat toXMLInputFormat(DataBaseInputFormat dataBaseInputFormat) {
        return new XMLInputFormat(
                dataBaseInputFormat.getIndex(),
                dataBaseInputFormat.getProducer(),
                new Screen(
                        dataBaseInputFormat.getIsTouchable(),
                        dataBaseInputFormat.getDiagonal(),
                        dataBaseInputFormat.getResolution(),
                        dataBaseInputFormat.getScreenType()
                ),
                new Processor(
                        dataBaseInputFormat.getProcessor(),
                        dataBaseInputFormat.getCoreNumber(),
                        dataBaseInputFormat.getFrequency()
                ),
                dataBaseInputFormat.getRAM(),
                new Disc(
                        dataBaseInputFormat.getDiskType(),
                        dataBaseInputFormat.getDiskSize()
                ),
                new GraphicCard(
                        dataBaseInputFormat.getGraphicCard(),
                        dataBaseInputFormat.getGraphicCardMemory()
                ),
                dataBaseInputFormat.getOperatingSystem(),
                dataBaseInputFormat.getOpticalDrive()
        );
    }

}
