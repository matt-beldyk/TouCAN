class Layer < ActiveRecord::Migration
  def self.up
    create_table :layers do |t|
        t.column :name, :string
        t.column :created_at, :timestamp
    end
  end

  def self.down
    drop_table :layers
  end


end
