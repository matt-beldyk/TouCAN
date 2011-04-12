class InterestPoints < ActiveRecord::Migration
  def self.up
    create_table :interest_points do |t|
        t.column :name, :string
        t.column :created_at, :timestamp
        t.column :lat, :float
        t.column :lon, :float
        t.column :words, :text
        t.column :picture, :text
        t.column :layer_id, :integer
    end
  end

  def self.down
    drop_table :interest_points
  end
end
