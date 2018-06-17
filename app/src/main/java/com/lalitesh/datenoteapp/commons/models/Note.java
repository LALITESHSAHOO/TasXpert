/*
 * Copyright (C) 2018 Lalitesh Sahoo (lsdevloper@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.lalitesh.datenoteapp.commons.models;

import com.google.gson.Gson;
import it.feio.android.omninotes.commons.utils.EqualityChecker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Note implements Serializable {

	private String title;
	private String content;
	private Long creation;
	private Long lastModification;
	private Boolean archived;
	private Boolean trashed;
	private String alarm;
	private Boolean reminderFired;
	private String recurrenceRule;
	private Double latitude;
	private Double longitude;
	private String address;
	private Category category;
	private Boolean locked;
	private Boolean checklist;
	private List<? extends Attachment> attachmentsList = new ArrayList<Attachment>();
	private List<? extends Attachment> attachmentsListOld = new ArrayList<Attachment>();


	public Note() {
		super();
		this.title = "";
		this.content = "";
		this.archived = false;
		this.trashed = false;
		this.locked = false;
		this.checklist = false;
	}


	public Note(Long creation, Long lastModification, String title, String content, Integer archived,
			Integer trashed, String alarm, Integer reminderFired, String recurrenceRule, String latitude, String longitude, Category
			category, Integer locked, Integer checklist) {
		super();
		this.title = title;
		this.content = content;
		this.creation = creation;
		this.lastModification = lastModification;
		this.archived = archived == 1;
		this.trashed = trashed == 1;
		this.alarm = alarm;
		this.reminderFired = reminderFired == 1;
		this.recurrenceRule = recurrenceRule;
		setLatitude(latitude);
		setLongitude(longitude);
		this.category = category;
//		this.address = address;
		this.locked = locked == 1;
		this.checklist = checklist == 1;
	}


	public Note(Note note) {
		super();
		buildFromNote(note);
	}


	private void buildFromNote(Note note) {
		setTitle(note.getTitle());
		setContent(note.getContent());
		setCreation(note.getCreation());
		setLastModification(note.getLastModification());
		setArchived(note.isArchived());
		setTrashed(note.isTrashed());
		setAlarm(note.getAlarm());
		setRecurrenceRule(note.getRecurrenceRule());
		setReminderFired(note.isReminderFired());
		setLatitude(note.getLatitude());
		setLongitude(note.getLongitude());
		setAddress(note.getAddress());
		setCategory(note.getCategory());
		setLocked(note.isLocked());
		setChecklist(note.isChecklist());
		ArrayList<Attachment> list = new ArrayList<Attachment>();
		for (Attachment mAttachment : note.getAttachmentsList()) {
			list.add(mAttachment);
		}
		setAttachmentsList(list);
	}


	public void buildFromJson(String jsonNote) {
		Gson gson = new Gson();
		Note noteFromJson = gson.fromJson(jsonNote, this.getClass());
		buildFromNote(noteFromJson);
	}


	public void set_id(Long _id) {
		this.creation = _id;
	}


	public Long get_id() {
		return creation;
	}


	public String getTitle() {
		if (title == null) return "";
		return title;
	}


	public void setTitle(String title) {
		this.title = title == null ? "" : title;
	}


	public String getContent() {
		if (content == null) return "";
		return content;
	}


	public void setContent(String content) {
		this.content = content == null ? "" : content;
	}


	public Long getCreation() {
		return creation;
	}


	public void setCreation(Long creation) {
		this.creation = creation;
	}


	public void setCreation(String creation) {
		Long creationLong;
		try {
			creationLong = Long.parseLong(creation);
		} catch (NumberFormatException e) {
			creationLong = null;
		}
		this.creation = creationLong;
	}


	public Long getLastModification() {
		return lastModification;
	}


	public void setLastModification(Long lastModification) {
		this.lastModification = lastModification;
	}


	public void setLastModification(String lastModification) {
		Long lastModificationLong;
		try {
			lastModificationLong = Long.parseLong(lastModification);
		} catch (NumberFormatException e) {
			lastModificationLong = null;
		}
		this.lastModification = lastModificationLong;
	}


	public Boolean isArchived() {
		return !(archived == null || !archived);
	}


	public void setArchived(Boolean archived) {
		this.archived = archived;
	}


	public void setArchived(int archived) {
		this.archived = archived == 1;
	}


	public Boolean isTrashed() {
		return !(trashed == null || !trashed);
	}


	public void setTrashed(Boolean trashed) {
		this.trashed = trashed;
	}


	public void setTrashed(int trashed) {
		this.trashed = trashed == 1;
	}


	public String getAlarm() {
		return alarm;
	}


	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}


	public void setAlarm(long alarm) {
		this.alarm = String.valueOf(alarm);
	}


	public Boolean isReminderFired() {
		return !(reminderFired == null || !reminderFired);
	}


	public void setReminderFired(Boolean reminderFired) {
		this.reminderFired = reminderFired;
	}


	public void setReminderFired(int reminderFired) {
		this.reminderFired = reminderFired == 1;
	}


	public String getRecurrenceRule() {
		return recurrenceRule;
	}


	public void setRecurrenceRule(String recurrenceRule) {
		this.recurrenceRule = recurrenceRule;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public void setLatitude(String latitude) {
		try {
			setLatitude(Double.parseDouble(latitude));
		} catch (NumberFormatException e) {
			this.latitude = null;
		} catch (NullPointerException e) {
			this.latitude = null;
		}
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public void setLongitude(String longitude) {
		try {
			setLongitude(Double.parseDouble(longitude));
		} catch (NumberFormatException e) {
			this.longitude = null;
		} catch (NullPointerException e) {
			this.longitude = null;
		}
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Boolean isLocked() {
		return !(locked == null || !locked);
	}


	public void setLocked(Boolean locked) {
		this.locked = locked;
	}


	public void setLocked(int locked) {
		this.locked = locked == 1;
	}


	public Boolean isChecklist() {
		return !(checklist == null || !checklist);
	}


	public void setChecklist(Boolean checklist) {
		this.checklist = checklist;
	}


	public void setChecklist(int checklist) {
		this.checklist = checklist == 1;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<? extends Attachment> getAttachmentsList() {
		return attachmentsList;
	}


	public void setAttachmentsList(List<? extends Attachment> attachmentsList) {
		this.attachmentsList = attachmentsList;
	}


	public void backupAttachmentsList() {
		List<Attachment> attachmentsListOld = new ArrayList<Attachment>();
		for (Attachment mAttachment : getAttachmentsList()) {
			attachmentsListOld.add(mAttachment);
		}
		this.attachmentsListOld = attachmentsListOld;
	}


	public List<? extends Attachment> getAttachmentsListOld() {
		return attachmentsListOld;
	}


	public void setAttachmentsListOld(List<? extends Attachment> attachmentsListOld) {
		this.attachmentsListOld = attachmentsListOld;
	}


	@Override
	public boolean equals(Object o) {
		boolean res = false;
		Note note;
		try {
			note = (Note) o;
		} catch (Exception e) {
			return res;
		}

		Object[] a = {getTitle(), getContent(), getCreation(), getLastModification(), isArchived(),
				isTrashed(), getAlarm(), getRecurrenceRule(), getLatitude(), getLongitude(), getAddress(), isLocked(),
				getCategory(), isChecklist() };
		Object[] b = {note.getTitle(), note.getContent(), note.getCreation(),
				note.getLastModification(), note.isArchived(), note.isTrashed(), note.getAlarm(), note
				.getRecurrenceRule(), note.getLatitude(), note.getLongitude(), note.getAddress(), note.isLocked(),
				note.getCategory(), note.isChecklist()};
		if (EqualityChecker.check(a, b)) {
			res = true;
		}

		return res;
	}


	public boolean isChanged(Note note) {
		return !equals(note) || !getAttachmentsList().equals(note.getAttachmentsList());
	}


	public boolean isEmpty() {
		Note emptyNote = new Note();
		// Field to exclude for comparison
		emptyNote.setCreation(getCreation());
		emptyNote.setCategory(getCategory());
		// Check
		return !isChanged(emptyNote);
	}


	public String toString() {
		return getTitle();
	}


	public String toJSON() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
