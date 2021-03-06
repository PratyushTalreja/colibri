package openADR.OADRMsgInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by georg on 07.06.16.
 * This class holds the important information for an oadrCreateReport message.
 */
public class MsgInfo_OADRCreateReport implements OADRMsgInfo {
    List<ReportRequest> reportRequests;

    public MsgInfo_OADRCreateReport(){
        reportRequests = new ArrayList<>();
    }

    public List<MsgInfo_OADRCreateReport.ReportRequest> getReportRequests() {
        return reportRequests;
    }

    public ReportRequest getNewReportRequest(){
        return new ReportRequest();
    }

    public SpecifierPayload getNewSpecifierPayload(){
        return new SpecifierPayload();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMsgType() {
        return "oadrCreateReport";
    }

    /**
     * This class holds the important information for a single report request.
     */
    public class ReportRequest{
        // Identifier for a particular report request
        private String reportRequestID;
        // Identifier for a particular Metadata report specification
        private String reportSpecifierID;
        /* Frequency of reported data. Value must be between
            SamplingRate.oadrMinPeriod and SamplingRate.oadrMaxPeriod.
            If 0, the requester is requesting the report to use onChange (if available) */
        private Long granularitySec;
        /* the interval for sending reports (oadrUpdateReport or orderRegisterReport)
            back to the requester. If reportBackDuration == 0, then it's only a one shot report
         */
        private Long reportBackDurationSec;
        // The start time of the period of reporting.
        private Date reportIntervalStart;
        // The duration of the period of reporting.
        private Long reportIntervalDuration;

        private List<SpecifierPayload> specifierPayloads;

        public ReportRequest(){
            specifierPayloads = new ArrayList<>();
        }

        public String getReportRequestID() {
            return reportRequestID;
        }

        public void setReportRequestID(String reportRequestID) {
            this.reportRequestID = reportRequestID;
        }

        public String getReportSpecifierID() {
            return reportSpecifierID;
        }

        public void setReportSpecifierID(String reportSpecifierID) {
            this.reportSpecifierID = reportSpecifierID;
        }

        public Long getGranularitySec() {
            return granularitySec;
        }

        public void setGranularitySec(Long granularitySec) {
            this.granularitySec = granularitySec;
        }

        public Long getReportBackDurationSec() {
            return reportBackDurationSec;
        }

        public void setReportBackDurationSec(Long reportBackDurationSec) {
            this.reportBackDurationSec = reportBackDurationSec;
        }

        public Date getReportIntervalStart() {
            return reportIntervalStart;
        }

        public void setReportIntervalStart(Date reportIntervalStart) {
            this.reportIntervalStart = reportIntervalStart;
        }

        public Long getReportIntervalDuration() {
            return reportIntervalDuration;
        }

        public void setReportIntervalDuration(Long reportIntervalDuration) {
            this.reportIntervalDuration = reportIntervalDuration;
        }

        public List<MsgInfo_OADRCreateReport.SpecifierPayload> getSpecifierPayloads() {
            return specifierPayloads;
        }

    }

    public class SpecifierPayload{
        // ReferenceID for this data point.
        private String rID;
        // Metadata about the Readings, such as mean or derived.
        private String readingType;

        public String getrID() {
            return rID;
        }

        public void setrID(String rID) {
            this.rID = rID;
        }

        public String getReadingType() {
            return readingType;
        }

        public void setReadingType(String readingType) {
            this.readingType = readingType;
        }
    }
}
